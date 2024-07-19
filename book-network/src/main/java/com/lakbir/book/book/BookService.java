package com.lakbir.book.book;

import com.lakbir.book.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * lakbir.abderrahim - 19/07/2024
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    public Integer save(BookRequest request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        Book book = bookMapper.toBook(request);
    }
}
