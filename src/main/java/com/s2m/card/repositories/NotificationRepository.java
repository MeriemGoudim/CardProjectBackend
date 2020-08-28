package com.s2m.card.repositories;

import com.s2m.card.models.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface NotificationRepository extends CrudRepository<Notification,Long> {
    @Query(value="select notification.* from notifications notification inner join users user on notification.id_user=user.id_user where user.username= ?1 and user.password= ?2 and notification.affichage = false", nativeQuery = true)
    List<Notification> findByUsernameAndPassword(String username, String password);

}
