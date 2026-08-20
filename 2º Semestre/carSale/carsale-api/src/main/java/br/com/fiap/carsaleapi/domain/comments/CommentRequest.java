package br.com.fiap.carsaleapi.domain.comments;

import br.com.fiap.carsaleapi.domain.car.Car;
import br.com.fiap.carsaleapi.domain.user.User;

import java.time.LocalDate;

public record CommentRequest(
        String comment,
        Long carId,
        Long userId
) {
    public Comment toModel() {
        var car = new Car();
        car.setId(carId);

        var user = new User();
        user.setId(userId);

        return Comment.builder()
                .comment(comment)
                .car(car)
                .createdDate(LocalDate.now())
                .user(user)
                .build();
    }
}
