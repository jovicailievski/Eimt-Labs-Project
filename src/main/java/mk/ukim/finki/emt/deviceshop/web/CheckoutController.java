package mk.ukim.finki.emt.deviceshop.web;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import mk.ukim.finki.emt.deviceshop.dto.ChargeRequest;
import mk.ukim.finki.emt.deviceshop.models.Product;
import mk.ukim.finki.emt.deviceshop.service.PaymentService;
import mk.ukim.finki.emt.deviceshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;


    @RequestMapping("/checkout/{id}")
    public String checkout(@PathVariable("id") Long id,
                           Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("name", product.getName());
        model.addAttribute("amount", product.getPrice().intValue()); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }

    @PostMapping("/charge")
    public String charge( ChargeRequest chargeRequest, Model model)
            throws StripeException {

        chargeRequest.setDescription("EMT payment");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = paymentService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }


}