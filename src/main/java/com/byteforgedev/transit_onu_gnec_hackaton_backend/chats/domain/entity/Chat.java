package com.byteforgedev.transit_onu_gnec_hackaton_backend.chats.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a title for the chat")
    @Size( max = 50, message = "The chat title must have a maximum 50 characters")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)  
    @Column(name = "chat_status", nullable = false)
    private ChatStatus chatStatus;

    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "author_user_id", insertable = false, updatable = false)
    private User user;

}
