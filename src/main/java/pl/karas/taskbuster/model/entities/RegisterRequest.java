package pl.karas.taskbuster.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

    private RegisterType registerType;
    private User user;
    private Authority authority;

}
