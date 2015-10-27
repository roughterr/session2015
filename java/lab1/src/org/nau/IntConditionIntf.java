package org.nau;

/**
 * Даний інтерфейс буде зручно використати при видаленні елементів зі списку по певній умові.
 */
@FunctionalInterface
public interface IntConditionIntf {
    /**
     * Показує чи введене число відповідає якомусь правилу чи ні.
     *
     * @param val
     * @return
     */
    boolean isConditionSatisfied(int val);
}
