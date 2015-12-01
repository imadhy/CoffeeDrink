##Backend

```json
POST http://www.coffeedrink.com/bonjour
IN
	token (String)
	// token de l'utilisateur
	
OUT
	Response (JSON) //Reponse par le backend
	{
		"call" : "bonjour"
		"answer" : {
			"Response" : "[401] J'te connais pas va t'authentifier"
		}
	}
```

+ L'utilisateur envoie un token
+ Le message est reçu en JSON
+ La response reçu par le backend est "[401] J'te connais pas va t'authentifier"

<br />

```json
POST http://www.coffeedrink.com/callback
IN
	tokenRecu (String)
	// token recu par le gestionnaire d'identification
	
OUT
	Response (JSON)
	{
		"call" : "callback"
		"answer" : {
			"Response" : "Ok"
		}
	}
```

+ L'utilisateur envoie le token reçu par le gestionnaire d'identification
+ Le message est reçu en JSON
+ La reponse reçu par le backend est "OK", il a reconnu le token envoyé par l'utilisateur