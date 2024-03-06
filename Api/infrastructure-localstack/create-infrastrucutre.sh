awslocal secretsmanager create-secret --name /secret/client-credentials  --secret-string "{\"client-marvel-public-key\":\"MARVEL_PUBLIC_KEY\", \"client-marvel-private-key\":\"MARVEL_PRIVATE_KEY\"}"

awslocal sns create-topic --name character-picture-topic
awslocal sqs create-queue --queue-name character-picture-queue
awslocal sns subscribe  --region us-east-1 --topic-arn arn:aws:sns:us-east-1:000000000000:character-picture-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:character-picture-queue
