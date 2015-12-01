##Backend

```json
POST http://www.coffeedrink.com/bonjour
IN
	token (String)
	// token de l'utilisateur
	
OUT
	Response (JSON)
	{
		"call" : "bonjour"
		"answer" : {
			"Response" : "[401] J'te connais pas va t'authentifier"
		}
	}
```







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