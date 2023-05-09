package main.java.com.recargaAPI.recargaAPI.dto;









import java.util.UUID;

public class PagamentoDto {
    

    private UUID idRecarga;

    private String numeroDoCelular;

    private int valorDaRecarga;

    private String STATUS;

    

    public UUID getIdRecarga() {
        return idRecarga;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String sTATUS) {
        STATUS = sTATUS;
    }

    public void setIdRecarga(UUID idRecarga) {
        this.idRecarga = idRecarga;
    }

    public String getNumeroDoCelular() {
        return numeroDoCelular;
    }

    public void setNumeroDoCelular(String numeroDoCelular) {
        this.numeroDoCelular = numeroDoCelular;
    }

    public int getValorDaRecarga() {
        return valorDaRecarga;
    }

    public void setValorDaRecarga(int valorDaRecarga) {
        this.valorDaRecarga = valorDaRecarga;
    }
    
    
    


}
