package com.lakbir.book.book;

import org.springframework.data.jpa.domain.Specification;

/**
 * lakbir.abderrahim - 20/07/2024
 */
public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
