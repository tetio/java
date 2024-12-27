public class GameMaster {

    public String describe(Character character) {
        return String.format("You're a level %d %s with %d hit points.", character.getLevel(),
                character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %d inhabitants.", destination.getName(),
                destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        return switch (travelMethod) {
            case TravelMethod.WALKING -> "You're traveling to your destination by walking.";
            case TravelMethod.HORSEBACK -> "You're traveling to your destination on horseback.";
        };
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return String.format("%s %s %s", describe(character), describe(travelMethod), describe(destination));
    }

    public String describe(Character character, Destination destination) {
        return String.format("%s %s %s", describe(character), describe(TravelMethod.WALKING), describe(destination));
    }
}
