package spring_test.device;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope(value="prototype")
@Data
public class Camera {
	int id;
}
