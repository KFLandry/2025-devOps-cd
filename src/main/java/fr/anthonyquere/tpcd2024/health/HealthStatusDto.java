package fr.anthonyquere.tpcd2024.health;

public record HealthStatusDto(String message, Status status) {

    public enum Status {
        UP,
        DOWN
    }
}
