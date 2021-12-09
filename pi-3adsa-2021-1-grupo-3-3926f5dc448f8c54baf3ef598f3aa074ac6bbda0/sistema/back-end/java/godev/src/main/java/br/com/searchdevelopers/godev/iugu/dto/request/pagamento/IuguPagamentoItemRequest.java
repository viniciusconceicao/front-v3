package br.com.searchdevelopers.godev.iugu.dto.request.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IuguPagamentoItemRequest {

    private String description;

    private Integer quantity;

    @JsonProperty("price_cents")
    private Integer priceCents;

    public IuguPagamentoItemRequest() {
    }

    public IuguPagamentoItemRequest(String description, Integer quantity, Integer priceCents) {
        this.description = description;
        this.quantity = quantity;
        this.priceCents = priceCents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(Integer priceCents) {
        this.priceCents = priceCents;
    }
}
