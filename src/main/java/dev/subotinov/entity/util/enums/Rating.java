package dev.subotinov.entity.util.enums;

public enum Rating {
    G, PG, PG_13, R, NC_17;

    @Override
    public String toString() {
        return name().replace("_", "-");
    }

    public static Rating fromDbValue(String dbValue) {
        return switch (dbValue) {
            case "G" -> G;
            case "PG" -> PG;
            case "PG-13" -> PG_13;
            case "R" -> R;
            case "NC-17" -> NC_17;
            default -> throw new IllegalArgumentException("Unknown rating: " + dbValue);
        };
    }
}
