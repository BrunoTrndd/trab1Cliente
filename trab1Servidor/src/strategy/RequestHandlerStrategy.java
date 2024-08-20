package strategy;

import dto.RequestDTO;

public interface RequestHandlerStrategy {

    String handleRequest(RequestDTO request);

}
