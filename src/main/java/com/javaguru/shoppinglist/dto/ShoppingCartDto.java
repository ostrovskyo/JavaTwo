package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Category;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartDto {

    @NotNull(groups = {ShoppingCartDto.Update.class})
    @Null(groups = {ShoppingCartDto.Create.class})
    private Long id;
    @NotEmpty(groups = {ShoppingCartDto.Update.class, ShoppingCartDto.Create.class}, message = "Name must be not blank.")
    private String name;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartDto that = (ShoppingCartDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShoppingCartDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
