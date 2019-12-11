package com.programmer.gsk;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestParam(value = "userId") int userId, @RequestParam(value = "itemId") String itemId) {
        BaseResponse response = new BaseResponse();

        if (sharedKey.equalsIgnoreCase(key)) {
            int user = userId;
            String item = itemId;

            // Process the request
            // ....
            // Return success response to the client.
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        } else {
            response.setStatus(ERROR_STATUS);
            response.setCode(AUTH_FAILURE);
        }
        return response;
    }

}
