class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

// Define the Warrior class
class Warrior extends Fighter {

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }
}

// Define the Wizard class
class Wizard extends Fighter {
    private boolean spellPrepared = false;

    void prepareSpell() {
        spellPrepared = true;
    }

    @Override
    boolean isVulnerable() {
        return !spellPrepared;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return spellPrepared ? 12 : 3;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}
