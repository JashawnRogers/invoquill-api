package com.jashawnbuilds.invoquill_api.identity.application.ports.in;

public record RegisterUseCaseCommand(
        String firstName,
        String lastName,
        String email
) {
}
