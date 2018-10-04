package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Peru");
		spain.setCapital("Lima");
		spain.setCurrency(Currency.SOLES);
		spain.setPopulation(46704314);

		countries.put(spain.getName(), spain);

		Country poland = new Country();
		poland.setName("Ecuador");
		poland.setCapital("Quito");
		poland.setCurrency(Currency.DOLAR);
		poland.setPopulation(38186860);

		countries.put(poland.getName(), poland);

		Country uk = new Country();
		uk.setName("Alemania");
		uk.setCapital("Berlín");
		uk.setCurrency(Currency.EURO);
		uk.setPopulation(63705000);

		countries.put(uk.getName(), uk);
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}
