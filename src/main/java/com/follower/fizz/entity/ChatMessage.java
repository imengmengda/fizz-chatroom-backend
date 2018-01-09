package com.follower.fizz.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lin on 17-12-23.
 */
@Entity
@Table(name = "chat_message", schema = "fizz_chat", catalog = "")
public class ChatMessage {
    private int messageId;
    private String messageContent;
    private Timestamp createdTime;
    private int recallFlag;

    @Id
    @Column(name = "message_id", nullable = false)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "message_content", nullable = false, length = 500)
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "created_time", nullable = false)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "recall_flag", nullable = false)
    public int getRecallFlag() {
        return recallFlag;
    }

    public void setRecallFlag(int recallFlag) {
        this.recallFlag = recallFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMessage that = (ChatMessage) o;

        if (messageId != that.messageId) return false;
        if (recallFlag != that.recallFlag) return false;
        if (messageContent != null ? !messageContent.equals(that.messageContent) : that.messageContent != null)
            return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + recallFlag;
        return result;
    }
}
