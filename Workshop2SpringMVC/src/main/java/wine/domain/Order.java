package wine.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import wine.utility.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Order extends BaseEntity<Long> {

    @NotNull
    @ManyToOne(optional = false)
    private Customer customer;

    @NotNull
    @OneToOne
    @JoinColumn(name = "invoiceID",
				referencedColumnName = "id")
    private Invoice invoice;

    @NotNull
    @OneToMany(mappedBy = "parentOrder",
			   fetch = FetchType.EAGER,
			   cascade = CascadeType.ALL,
			   orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<OrderLineItem> itemsInOrder;

    private BigDecimal orderPriceTotal;
    private int orderItemsTotal;
    private boolean shipped;
    private boolean completed;

    public void setOrderItems(List<OrderLineItem> lineItems) {
        if(itemsInOrder == null) {
            this.itemsInOrder = lineItems;
        } else {
            this.itemsInOrder.retainAll(lineItems);
            this.itemsInOrder.addAll(lineItems);
        }
    }

    public void setOrderPriceTotal(List<OrderLineItem> lineItems) {
        BigDecimal orderPriceTotal = BigDecimal.ZERO;
        ListIterator<OrderLineItem> it = lineItems.listIterator();
        while(it.hasNext()) {
            OrderLineItem lineItem = it.next();
            BigDecimal itemPrice = lineItem.getProduct().getPrice();
            int itemQuantity = lineItem.getProductQuantity();
            orderPriceTotal = orderPriceTotal.add(itemPrice.multiply(new BigDecimal(itemQuantity)));
        }
        this.orderPriceTotal = orderPriceTotal;
    }

    public void setOrderItemsTotal(List<OrderLineItem> lineItems) {
        ListIterator<OrderLineItem> it = lineItems.listIterator();
        int totalOfLineItemQuantities = 0;
        while(it.hasNext()) {
            OrderLineItem lineItem = it.next();
            int itemQuantity = lineItem.getProductQuantity();
            totalOfLineItemQuantities += itemQuantity;
        }
        this.orderItemsTotal = totalOfLineItemQuantities;
    }
}
