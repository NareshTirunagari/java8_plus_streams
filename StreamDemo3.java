import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo3 {

    public static void main(String[] args) {

        List<Product> products = SampleData.getProductData();
        List<Customer> customers = SampleData.getCustomerData();
        List<Order> orders = SampleData.getOrderData();

        //Scenario: Find all electronic products and create a list of their names.
        List<String> electronicProductNames = products.stream()
                .filter(product -> product.category().equals("Electronics"))
                .map(Product::name)
                .collect(Collectors.toList());

        System.out.println(electronicProductNames);
        // Output: [iPhone 14, MacBook Pro, Wireless Earbuds, Smart Watch]

        //Scenario: Find the first product in the “Sportswear” category that costs less than $20.
        Optional<Product> affordableSportswearProduct = products.stream()
                .filter(product -> product.category().equals(("Sportswear")))
                .filter(product -> product.price().compareTo(new BigDecimal("20")) < 0)
                .findFirst();

        affordableSportswearProduct.ifPresent(product -> System.out.println("Affordable sportswear: " + product.name() + " - $" + product.price()));
        // Output: Affordable sportswear: Water Bottle - $12.99

        //Scenario: Create a list of order summaries showing order ID and total item count.
        List<OrderSummary> orderSummaries = orders.stream()
                .map(order -> new OrderSummary(
                        order.id(),
                        order.items().stream()
                                //.mapToInt(orderItem -> orderItem.quantity())
                                .mapToInt(OrderItem::quantity)
                                .sum()
                ))
                .collect(Collectors.toList());

        orderSummaries.forEach(System.out::println);

        //Scenario: Show all products sorted by price (lowest to highest).
        List<Product> sortedProducts = products.stream()
                //.sorted(Comparator.comparing(product -> product.price()))
                .sorted(Comparator.comparing(Product::price))
                .collect(Collectors.toList());

        sortedProducts.forEach(System.out::println);

        //Scenario: Show all products sorted by price (highest to lowest).
        List<Product> sortedProductsDesc = products.stream()
                //.sorted(Comparator.comparing(product -> product.price()))
                .sorted(Comparator.comparing(Product::price).reversed())
                .collect(Collectors.toList());

        sortedProductsDesc.forEach(System.out::println);

        //Scenario: Implement a simple pagination for products, showing the second page with 3 products per page.
        int pageSize = 3;
        int pageNumber = 1; // 0-based index, so this is the second page
        int byPassPageNbr = pageSize * pageNumber;
        System.out.println("byPassPageNbr:"+byPassPageNbr);
        List<Product> paginatedProducts = products.stream()
                .skip(byPassPageNbr)
                .limit(pageSize)
                .collect(Collectors.toList());

        paginatedProducts.forEach(product -> System.out.println("productname:"+product.name()));


        //Scenario: Create a list of all products that have been ordered.
        List<Product> orderedProducts = orders.stream()
                .flatMap(order -> order.items().stream())
                .map(orderItem -> orderItem.product())
                .distinct()
//                .sorted(Comparator.comparing(Product::name))
//                .sorted(Comparator.comparing(product -> product.name()))
                .sorted(Comparator.comparing(Product::name).reversed())
                .collect(Collectors.toList());

        orderedProducts.forEach(product -> System.out.println("productname:"+product.name()));

        //Scenario: Calculate the total revenue from all orders.
        orders.stream()
                .flatMap(order -> order.items().stream())
                .map(orderItem -> orderItem.product().price().multiply(BigDecimal.valueOf(orderItem.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
