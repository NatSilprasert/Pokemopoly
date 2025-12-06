package com.pokemopoly;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.*;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.player.Player;
import com.pokemopoly.player.ProfessionType;

import java.util.*;

public class Battle {
    private Game game;
    private Player player;
    private Player opponent;
    private PokemonCard playerPokemon;
    private PokemonCard opponentPokemon;
    private boolean bot;
    private int playerOriginalPower;
    private int opponentOriginalPower;
    // เก็บค่าพลังเดิมเพื่อนำไปคืนค่า
    private Map<PokemonCard, Integer> originalPowerMap = new HashMap<>();
    private boolean disableItems = false;
    private boolean disableItemUsage = false;
    private boolean sandAttackActive = false;
    private boolean oddishBoosted = false;
    private PokemonCard firstAttacker = null;
    private boolean poliwrathExtraAttack = false;
    private Set<PokemonCard> clearBodyPokemons = new HashSet<>();
    private PokemonCard destinyBondUser = null;
    private Set<PokemonCard> sturdyPokemons = new HashSet<>();

    Random random = new Random();
    int chance = random.nextInt(100); // 0-99

    public Battle(Game game, Player p1, Player p2, boolean isBot) {
        this.game = game;
        this.player = p1;
        this.opponent = p2;
        this.bot = isBot;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Battle started!");

        // 1) เลือกโปเกม่อนก่อน
        playerPokemon = selectPokemon(player, scanner);

        if (bot) {
            opponentPokemon = opponent.getTeam().getFirst();
        } else {
            opponentPokemon = selectPokemon(opponent, scanner);
        }

        // 2) เรียก passive หลังเลือกโปเกม่อน
        if (playerPokemon instanceof BattleAbility ba1) {
            ba1.useBattlePassive(this);
        }
        if (opponentPokemon instanceof BattleAbility ba2) {
            ba2.useBattlePassive(this);
        }

        // 3) ทอยเต๋ารอบแรก (สำหรับ Dynamic Punch)
        int playerRoll = game.rollDice();
        int opponentRoll = game.rollDice();

        // 4) Dynamic Punch เช็คที่นี่
        if (playerPokemon instanceof Poliwrath && playerRoll == 6) {
            System.out.println("🔥 Poliwrath rolled a 6! Dynamic Punch activated! Extra attack granted!");
            setPoliwrathExtraAttack(true);
        }

        if (opponentPokemon instanceof Poliwrath && opponentRoll == 6) {
            System.out.println("🔥 Opponent's Poliwrath rolled a 6! Dynamic Punch activated! Extra attack granted!");
            setPoliwrathExtraAttack(true);
        }

        // 5) เริ่ม Battle Loop
        boolean isWin = false;

        while (!isWin) {
            int rollP = game.rollDice();
            int rollO = game.rollDice();

            if (rollP > rollO) {
                isWin = attack(player, opponent, playerPokemon, opponentPokemon);
            }
            else if (rollO > rollP) {
                isWin = attack(opponent, player, opponentPokemon, playerPokemon);
            }
            // ถ้าเท่ากันก็วนต่อ
        }

        // 6) หลังจบการต่อสู้
        endBattle();
    }


    private PokemonCard selectPokemon(Player player, Scanner scanner) {
        System.out.println(player.getName() + ", choose your pokemon:");

        List<PokemonCard> playerPokemon = player.getTeam();
        for (int i = 0; i < playerPokemon.size(); i++) {
            System.out.println(i + 1 + ". " + playerPokemon.get(i).getName());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return playerPokemon.get(choice - 1);
    }

    private void resetPokemonPowers() {
        playerPokemon.setPower(playerPokemon.getMaxPower());
        opponentPokemon.setPower(opponentPokemon.getMaxPower());
        System.out.println("🔁 Both Pokémon's power have been restored to their original values.");
    }

    public PokemonCard getOpponentPokemon(PokemonCard pokemon) {
        if (pokemon == playerPokemon) {
            return opponentPokemon;
        } else if (pokemon == opponentPokemon) {
            return playerPokemon;
        }
        return null;
    }

    public boolean attack(Player attacker, Player defender, PokemonCard attackerPokemon, PokemonCard defenderPokemon) {
        System.out.println(attacker.getName() + "'s attack " + defender.getName() + "!");

        // ⭐⭐ Snow Cloak check
        if (defenderPokemon instanceof Articuno) {
            int roll = game.rollDice(); // 1–6
            if (roll == 1) { // 1/6 ≈ 16.6% หรือปรับเป็น 20% ได้
                System.out.println("❄️ Snow Cloak! Articuno completely dodged the attack!");
                return false; // ไม่โดนดาเมจ, ไม่จบเกม
            }
        }

        int damage = attackerPokemon.getPower();

        // check for additional damage
        if (attacker.getProfession() == ProfessionType.TRAINER) {
            damage += 2;
        }

        if (isSandAttackActive()) {
            if (chance < 20) {  // 20% miss
                System.out.println("❌ Attack missed due to Sand Attack! (20% miss chance)");
                return true; // ไม่ทำดาเมจ
            }
        }

        // ตั้งผู้โจมตีคนแรก
        if (firstAttacker == null) {
            firstAttacker = attackerPokemon;
        }

        defenderPokemon.setHp(defenderPokemon.getHp() - damage);
        // -----------------------------
        // Victreebel Leech Life (+2 HP)
        // -----------------------------
        if (attackerPokemon instanceof Victreebel) {
            int newHp = Math.min(attackerPokemon.getHp() + 2, attackerPokemon.getMaxHp());
            attackerPokemon.setHp(newHp);
            System.out.println("🌿 Victreebel absorbs life! +" + 2 + " HP (" + newHp + ")");
        }

        // -----------------------------
        // Kabuto Absorb (+2 HP when hits successfully)
        // -----------------------------
        if (attackerPokemon instanceof Kabuto) {
            int newHp = Math.min(attackerPokemon.getHp() + 2, attackerPokemon.getMaxHp());
            attackerPokemon.setHp(newHp);
            System.out.println("🟤 Kabuto used Absorb! +" + 2 + " HP (" + newHp + ")");
        }

        if (defenderPokemon instanceof Victreebel) {
            int newHp = Math.min(defenderPokemon.getHp() + 2, defenderPokemon.getMaxHp());
            defenderPokemon.setHp(newHp);
            System.out.println("🌿 Victreebel absorbs life after being hit! +" + 2 + " HP (" + newHp + ")");
        }

        if (attackerPokemon instanceof Magnemite && defenderPokemon.isAlive()) {
            if (!defenderPokemon.isParalyzed()) {
                defenderPokemon.setParalyzed(true);
                System.out.println("⚡ Thunder Wave! " + defenderPokemon.getName() + " is now paralyzed!");
            }
        }

        // ==========================
        // Cloyster Icicle Crash
        // ==========================
        if (attackerPokemon instanceof com.pokemopoly.cards.pokemon.Cloyster) {
            triggerCloysterIcicleCrash(attacker, defender, attackerPokemon, defenderPokemon);
        }

        // ==========================
        //       STURDY CHECK
        // ==========================
        if (sturdyPokemons.contains(defenderPokemon)) {
            if (defenderPokemon.getHp() <= 0 && defenderPokemon.getHp() == defenderPokemon.getMaxHp()) {
                defenderPokemon.setHp(1); // survive with 1 HP
                sturdyPokemons.remove(defenderPokemon); // one-time use
                System.out.println("🪨 Sturdy! " + defenderPokemon.getName() + " hangs on with 1 HP!");
                return false; // battle continues
            }
            // If HP was not max before this hit → Sturdy does NOT activate
            sturdyPokemons.remove(defenderPokemon);
        }

        // ==========================
        // Zapdos Static Ability
        // ==========================
        if (defenderPokemon instanceof Zapdos zap) {
            if (attackerPokemon.isAlive()) {
                zap.tryActivateStatic(this, attackerPokemon);
            }
        }

        if (defenderPokemon.getHp() <= 0) {
            // ----------------------
            // DESTINY BOND CHECK
            // ----------------------
            if (defenderPokemon == destinyBondUser) {
                int roll = game.rollDice();
                System.out.println("💀 Destiny Bond activated! Rolled: " + roll);

                if (roll >= 5) {
                    System.out.println("☠️ Destiny Bond succeeds! "
                            + attackerPokemon.getName()
                            + " is knocked out!");
                    attackerPokemon.setHp(0); // Opponent dies too
                }
            }

            System.out.println(attacker.getName() + " win!");

            // player vs bot rewards
            if (bot && attacker == player) {
                attacker.setCoin(attacker.getCoin() + 5);
                if (Objects.equals("Gym 1's Leader", defender.getName())) {
                    attacker.setBadges1();
                }
                else if (Objects.equals("Gym 2's Leader", defender.getName())) {
                    attacker.setBadges2();
                }
                else if (Objects.equals("Villain", defender.getName())) {
                    List<PokemonCard> evolvablePokemons = attacker.getTeam().stream()
                            .filter(p -> p instanceof Evolvable)
                            .toList();

                    if (!evolvablePokemons.isEmpty()) {
                        System.out.println("Choose pokemon to evolve!");
                        for (int i = 0; i < evolvablePokemons.size(); i++) {
                            System.out.println((i + 1) + ". " + evolvablePokemons.get(i).getName());
                        }
                    }

                    Scanner scanner = new Scanner(System.in);
                    int choice = -1;

                    while (true) {
                        if (scanner.hasNextInt()) {
                            choice = scanner.nextInt();
                            if (choice >= 1 && choice <= evolvablePokemons.size()) {
                                break;
                            } else {
                                System.out.println("❌ Invalid number. Please select between 1 and " + evolvablePokemons.size() + "!");
                            }
                        } else {
                            System.out.println("❌ Please enter a valid number!");
                            scanner.next();
                        }
                    }

                    PokemonCard selected = evolvablePokemons.get(choice - 1);
                    System.out.println("You chose " + selected.getName() + " to evolve!");

                    Evolvable evolvable = (Evolvable) selected;
                    PokemonCard evolvedPokemon = evolvable.evolve();

                    int index = attacker.getTeam().indexOf(selected);
                    if (index != -1) {
                        attacker.getTeam().set(index, evolvedPokemon);
                    }

                    System.out.println("It has evolved to " + selected.getName() + "!");
                }
            }
            // player vs player rewards
            else {
                attacker.setCoin(attacker.getCoin() + 3);
            }

            resetPokemonPowers();
            return true;
        }

        if (hasPoliwrathExtraAttack() && attackerPokemon instanceof Poliwrath) {
            System.out.println("💥 Dynamic Punch activated! Extra attack!");
            setPoliwrathExtraAttack(false);

            boolean winAfterExtra = attack(attacker, defender, attackerPokemon, defenderPokemon);
            if (winAfterExtra) {
                return true;
            }
        }

        return false;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Player getOpponent(Player p) {
        if (p == player) return opponent;
        if (p == opponent) return player;
        return null; // not in this battle
    }

    public void addTemporaryPowerAdjustment(PokemonCard card, int originalPower) {
        originalPowerMap.put(card, originalPower);
    }

    public void restoreAllTemporaryStats() {
        for (Map.Entry<PokemonCard, Integer> entry : originalPowerMap.entrySet()) {
            entry.getKey().setPower(entry.getValue());
        }
        originalPowerMap.clear();
    }

    private void triggerBattlePassives() {
        if (playerPokemon instanceof BattleAbility ba) {
            ba.useBattlePassive(this);
        }
        if (opponentPokemon instanceof BattleAbility ba) {
            ba.useBattlePassive(this);
        }
    }

    private void playerUseItem() {
        if (isItemUsageDisabled()) {
            System.out.println("❌ Items are disabled this battle due to Unnerve!");
            return;
        }

        // logic ใช้ไอเท็มจริง
    }

    // =======================
    // Cloyster Icicle Crash logic
    // =======================
    public void triggerCloysterIcicleCrash(Player attacker, Player defender, PokemonCard cloyster, PokemonCard defenderPokemon) {

        // Attack #2 trigger
        int roll = game.rollDice();
        System.out.println("🎲 Cloyster rolled: " + roll);

        if (roll == 1) {
            System.out.println("❄️ Icicle Crash! Cloyster attacks a second time!");
            boolean win = attack(attacker, defender, cloyster, defenderPokemon);
            if (win) return; // battle ends

            // Attack #3 trigger
            int roll2 = game.rollDice();
            System.out.println("🎲 Cloyster rolled again: " + roll2);

            if (roll2 == 2) {
                System.out.println("❄️❄️ Icicle Crash! Cloyster attacks a third time!");
                attack(attacker, defender, cloyster, defenderPokemon);
            }
        }
    }

    public void endBattle() {
        // ---- คืนค่า Ditto ----
        if (playerPokemon instanceof Ditto d1) {
            d1.restoreOriginalStats();
        }
        if (opponentPokemon instanceof Ditto d2) {
            d2.restoreOriginalStats();
        }

        disableItemUsage = false;
        firstAttacker = null;

        if (playerPokemon instanceof Oddish) {
            playerPokemon.setPower(playerPokemon.getPower() - 2);
        }
    }

    public void disableItemsForThisBattle() {
        this.disableItems = true;
    }

    public boolean isItemDisabled() {
        return this.disableItems;
    }

    public void setDisableItemUsage(boolean disabled) {
        this.disableItemUsage = disabled;
    }

    public boolean isItemUsageDisabled() {
        return disableItemUsage;
    }

    public boolean isSandAttackActive() {
        return sandAttackActive;
    }

    public void setSandAttackActive(boolean sandAttackActive) {
        this.sandAttackActive = sandAttackActive;
    }

    public boolean isOddishBoosted() { return oddishBoosted; }
    public void setOddishBoosted(boolean b) { oddishBoosted = b; }

    public PokemonCard getFirstAttacker() {
        return firstAttacker;
    }

    public PokemonCard getPokemonOf(PokemonCard card) {
        return (playerPokemon == card) ? playerPokemon : opponentPokemon;
    }

    public boolean hasPoliwrathExtraAttack() {
        return poliwrathExtraAttack;
    }

    public void setPoliwrathExtraAttack(boolean value) {
        this.poliwrathExtraAttack = value;
    }

    public boolean hasClearBody(PokemonCard card) {
        return clearBodyPokemons.contains(card);
    }

    public void addClearBody(PokemonCard card) {
        clearBodyPokemons.add(card);
    }

    public void setDestinyBond(PokemonCard card) {
        this.destinyBondUser = card;
    }

    public void registerSturdy(PokemonCard card) {
        sturdyPokemons.add(card);
    }

    public Game getGame() {
        return game;
    }
}
