INSERT INTO
    chat."user"(login, password)
VALUES
    ('Victory', 'treeeeeeee'),
    ('Manarbeck', 'DeReVyAsHkA'),
    ('Annette', 'PINKYpink'),
    ('Alex', 'Mumbai'),
    ('Garfild', 'lasagna'),
    ('Beethoven', 'GuFGuF')
ON CONFLICT DO NOTHING;

INSERT INTO
    chat.chatroom(name, owner)
VALUES
    ('Sale and buy', 2),
    ('Freelance help', 1),
    ('Job search', 5),
    ('LA travel `23', 1),
    ('Find friends', 3)
ON CONFLICT DO NOTHING;

INSERT INTO
    chat.message("text", author, room)
VALUES
    ('Hi, wanna sell my house', 1, 1),
    ('Price?', 2, 1),
    ('Where download Photoshop?', 3, 2),
    ('I need assistant', 4, 3),
    ('Tomorrow will send photos', 5, 4)
ON CONFLICT DO NOTHING;

INSERT INTO
    chat.user_chatroom(user_id, room_id)
VALUES
    (1, 1),
    (2, 1),
    (1, 2),
    (1, 4),
    (3, 2),
    (3, 5),
    (4, 3),
    (5, 3),
    (5, 4)
ON CONFLICT DO NOTHING;