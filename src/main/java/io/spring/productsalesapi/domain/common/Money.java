package io.spring.productsalesapi.domain.common;

public record Money(double amount) {
    public static final Money ZERO = Money.of(0);

    public static Money of(double amount) {
        return new Money(amount);
    }

    public Money calculatePercent(double percent) {
        return Money.of(this.amount * percent);
    }

    public Money minus(Money money) {
        return Money.of(this.amount - money.amount);
    }
}
