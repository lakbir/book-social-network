package com.lakbir.book.feedback;

import lombok.*;

/**
 * lakbir.abderrahim - 22/07/2024
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse {
    private Double note;
    private String comment;
    private boolean ownFeedback;
}
