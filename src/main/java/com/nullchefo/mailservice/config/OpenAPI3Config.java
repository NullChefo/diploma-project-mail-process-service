package com.nullchefo.mailservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

//TODO fix server for development
@OpenAPIDefinition(servers = { @Server(url = "https://backend.nullchefo.com/mail-process") },  info = @Info(title = "Mail Process Service APIs", version = "v0.0.1", description = "Mail Process Service API", contact = @Contact(url = "https://nullchefo.com", name = "Stefan", email = "stefank.dev.acc@gmail.com")))
@SecurityScheme(
		name = "security_auth",
		type = SecuritySchemeType.OAUTH2,
		//		in = SecuritySchemeIn.HEADER,
		//		bearerFormat = "jwt",
		flows = @OAuthFlows(
				authorizationCode = @OAuthFlow(
						authorizationUrl = "https://auth.nullchefo.com/oauth2/authorize",
						tokenUrl = "https://auth.nullchefo.com/oauth/token",
						scopes = {
								@OAuthScope(name = "openid", description = "openid scope"),
								@OAuthScope(name = "mail-process.read", description = "with this scope, the user can access every get request"),
								@OAuthScope(name = "mail-process.write", description = "with this scope, the user can access every post, put and delete request")
						}
				)
		)
)

public class OpenAPI3Config {
}
