package tacos;


import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

    private Date placedAt = new Date();

    // свойства с адресом доставки и номером кредитной карты опущены для краткости
    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();
    public void addTaco(TacoUDT taco) {
        this.tacos.add(taco);
    }
}