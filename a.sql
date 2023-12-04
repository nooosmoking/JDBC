-- Active: 1701514911929@@127.0.0.1@5432@postgres@chat
SELECT u.*, cr_r.id AS create_room_id, cr_r.name AS create_room_name, soc_r.id  AS social_room_id, soc_r.name AS social_room_name, us.login AS social_room_own_login, us.password AS social_room_own_pass
                 FROM (SELECT * FROM chat."user" ORDER BY "user".id LIMIT 1 OFFSET 0) AS u
                 LEFT JOIN chat.chatroom cr_r ON cr_r.owner = u.id 
                 LEFT JOIN chat.user_chatroom uc ON uc.user_id = u.id 
                 LEFT JOIN chat.chatroom soc_r ON uc.room_id = soc_r.id 
                 LEFT JOIN chat."user" us ON soc_r.owner = us.id
                 ORDER BY u.id, create_room_id, social_room_id;

                 SELECT u.*, c.id, c.name, uc.room_id, ct.name, us.id, us.login, us.password
                  FROM (SELECT * FROM chat.user LIMIT 1 OFFSET 0) u 
                 LEFT JOIN chat.chatroom c ON u.id = c.owner 
                 LEFT JOIN chat.user_chatroom uc ON u.id = uc.user_id 
                 LEFT JOIN chat.chatroom ct ON uc.room_id = ct.id 
                 LEFT JOIN chat.user us ON ct.owner = us.id 
                 ORDER BY u.id, c.id, uc.room_id;