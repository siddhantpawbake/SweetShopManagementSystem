import { useState } from "react";
import api from "../api/api";

export default function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const res = await api.post("/auth/login", {
                username,
                password,
            });

            localStorage.setItem("token", res.data.token);
            window.location.href = "/dashboard";
        } catch (err) {
            setError("Invalid username or password");
        }
    };

    return (
        <div style={{ padding: 40 }}>
            <h2>Login</h2>

            {error && <p style={{ color: "red" }}>{error}</p>}

            <form onSubmit={handleLogin}>
                <input
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <br /><br />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <br /><br />

                <button type="submit">Login</button>
            </form>
        </div>
    );
}
