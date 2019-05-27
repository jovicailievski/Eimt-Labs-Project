package mk.ukim.finki.emt.deviceshop.service;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import mk.ukim.finki.emt.deviceshop.dto.ChargeRequest;

public interface StripeService {

    Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException
}
