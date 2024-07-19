package com.lakbir.book.config;

import com.lakbir.book.entities.User;
import org.eclipse.angus.mail.imap.protocol.UIDSet;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * lakbir.abderrahim - 19/07/2024
 */
public class ApplicationAuditAware implements AuditorAware<Integer> {


    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null ||
        !authentication.isAuthenticated() ||
            authentication instanceof AnonymousAuthenticationToken){
            return Optional.empty();
        }
        User userPrincipal = (User) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}