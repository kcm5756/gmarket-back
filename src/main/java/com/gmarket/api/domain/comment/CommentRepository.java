package com.gmarket.api.domain.comment;


import com.gmarket.api.domain.comment.enums.CommentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // Bean Component
@RequiredArgsConstructor // @RequiredArgsConstructor 어노테이션은 final, @NonNull 필드 값만 파라미터로 받는 생성자를 만듬
public class CommentRepository {
    private final EntityManager em;

    // 다형성 구현을 위해서는 JPA 쿼리가 Comment 엔티티가 아닌, Comment SubType 엔티티를 조회해야 합니다.
    // 또한, 가급적 쿼리를 사용하지 않고 JPA에서 제공하는 메서드로 Repository를 구현하고자 합니다.
    // Spring data JPA를 활용한 Repository에서 Comment 엔티티가 아닌 Comment SubType 엔티티로 조회하는 메서드 구현의 어려움으로 인해
    // 현재로서는 EntityManager 메서드를 이용하여 처리하였습니다.
    // 추후에 공부하여 Spring data jpa Repository의 메서드로 Comment SubType 엔티티로 조회하도록 변경할 예정입니다.(또는 QueryDsl)

    public List<Comment> findCommentList(Comment comment, CommentStatus commentStatus){
        return em.createQuery("SELECT m FROM "+ comment.getClass().getSimpleName()
                + " m WHERE m.status !='" + commentStatus+"'").getResultList();
    }
}
