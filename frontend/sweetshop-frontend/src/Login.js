import { useState } from "react";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const login = async () => {
        const res = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        const data = await res.json();

        if (data.token) {
            localStorage.setItem("token", data.token);
            alert("Login success");
        } else {
            alert("Login failed");
        }
    };

    return (
        <div style={{ margin: "100px" }}>
            <h2>Login</h2>
            <input
                placeholder="Username"
                onChange={e => setUsername(e.target.value)}
            />
            <br /><br />
            <input
                type="password"
                placeholder="Password"
                onChange={e => setPassword(e.target.value)}
            />
            <br /><br />
            <button onClick={login}>Login</button>
        </div>
    );
}

export default Login;
