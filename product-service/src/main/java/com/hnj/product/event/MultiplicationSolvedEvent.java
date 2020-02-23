package com.hnj.product.event;

import lombok.*;

import java.io.Serializable;

/**
 * Event received when a multiplication has been solved in the system.
 * Provides some context information about the multiplication.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
class MultiplicationSolvedEvent implements Serializable {

    private final Long multiplicationResultAttemptId;
    private final Long userId;
    private final boolean correct;

}
