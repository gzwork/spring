package com.gzwork.common;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码管理
 *
 * @author Gzwork
 */
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword);
    }
}
