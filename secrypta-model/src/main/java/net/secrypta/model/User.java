package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "user")
public class User {

    @Id
    private UUID userId;

    @NotNull
    @Column
    @Size(max = 255)
    private String username;

    @Column
    @NotNull
    private String passwordHash;

    private String transientPassword;

    @Column
    @Email
    private String email;

    @Column
    @NotNull
    private boolean active;

    @Column
    @NotBlank
    private byte[] publicKey;

    @Column
    @NotBlank
    private byte[] privateKey;

    @Column
    private Set<UUID> userGroups;

    @Column
    private Date createdDate;

    @Column
    private Date lastUpdated;

    public boolean isActive() {
        return active;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getTransientPassword() {
        return transientPassword;
    }

    public void setTransientPassword(String transientPassword) {
        this.transientPassword = transientPassword;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    public Set<UUID> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UUID> userGroups) {
        this.userGroups = userGroups;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;

        return Objects.equal(this.getUserId(), other.getUserId()) && Objects.equal(this.getUsername(), other.getUsername())
                && Objects.equal(this.getPasswordHash(), other.getPasswordHash()) && Objects.equal(this.getEmail(), other.getEmail())
                && Objects.equal(this.getPublicKey(), other.getPublicKey());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getUserId(), this.getUsername(), this.getPasswordHash(), this.getEmail(), this.getPublicKey());
    }

    @Override
    public String toString() {
        if (this.getEmail() != null) {
            return this.getUsername() + " (" + this.getEmail() + ")";
        } else {
            return this.getUsername();
        }
    }
}
