export default function Dashboard() {
    return (
        <div style={{ padding: 40 }}>
            <h1>Welcome to Sweet Shop 🍬</h1>
            <button
                onClick={() => {
                    localStorage.removeItem("token");
                    window.location.href = "/";
                }}
            >
                Logout
            </button>
        </div>
    );
}
