# Simple Supabase User Test App

This is a minimal Spring Boot app to test connection with Supabase Postgres.

## What it does

- Add a user (`POST /users`)
- List all users (`GET /users`)

## Put your Supabase credentials in code

Open `src/main/java/com/example/demo/config/SupabaseDbConfig.java` and replace:

- `SUPABASE_DB_URL`
- `SUPABASE_DB_USER`
- `SUPABASE_DB_PASSWORD`
- `SUPABASE_CONNECTION_KEY` (placeholder only)

No database settings are stored in `application.properties`.

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

## Quick test

Create a user:

```powershell
Invoke-RestMethod -Method Post -Uri http://localhost:8080/users -ContentType "application/json" -Body '{"name":"Alice","email":"alice@example.com"}'
```

List users:

```powershell
Invoke-RestMethod -Method Get -Uri http://localhost:8080/users
```

