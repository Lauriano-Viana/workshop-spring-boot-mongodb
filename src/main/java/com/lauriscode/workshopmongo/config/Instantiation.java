package com.lauriscode.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lauriscode.workshopmongo.domain.Post;
import com.lauriscode.workshopmongo.domain.User;
import com.lauriscode.workshopmongo.dto.AuthorDTO;
import com.lauriscode.workshopmongo.repository.PostRepository;
import com.lauriscode.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		var maria = new User(null, "Maria Brown", "maria@gmail.com");
		var alex = new User(null, "Alex Green", "alex@gmail.com");
		var bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf1.parse("21/03/2024"), "Partiu Viagem", "Vou pra CN", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf1.parse("22/03/2024"), "Bom dia", "Feliz",new AuthorDTO(maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
		

	}

}
