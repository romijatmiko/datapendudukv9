package com.romijatmiko.Studentproject.service.framework;

import com.romijatmiko.Studentproject.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}

