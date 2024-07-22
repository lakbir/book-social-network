package com.lakbir.book.common;

import lombok.*;

import java.util.List;

/**
 * lakbir.abderrahim - 20/07/2024
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
}
