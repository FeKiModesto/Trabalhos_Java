CREATE TABLE board_game (
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    min_players INTEGER NOT NULL,
    max_players INTEGER NOT NULL,
    rating     NUMERIC(3, 1) NOT NULL,
    image_url  VARCHAR(500)
);
