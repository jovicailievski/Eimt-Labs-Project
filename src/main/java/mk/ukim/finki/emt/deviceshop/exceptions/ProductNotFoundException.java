package mk.ukim.finki.emt.deviceshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product not found exception")
public class ProductNotFoundException extends RuntimeException {
}
