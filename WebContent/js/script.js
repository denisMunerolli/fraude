document.getElementById("formFraude").addEventListener("submit", function (e) {
    e.preventDefault();

    const valor = parseFloat(document.getElementById("valor").value);
    const internacional = document.getElementById("internacional").checked;

    const suspeita = valor > 10000 || internacional;

    document.getElementById("resultado").textContent = suspeita
        ? "🚨 Possível fraude detectada!"
        : "✅ Transação normal.";
});
