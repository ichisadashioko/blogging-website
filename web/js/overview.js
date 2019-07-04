window.onload = () => {
    page_control = document.getElementById("page-control")
    page_control.onchange = (evt) => {
        selected_value = page_control.value
        window.location.href = `overview.jsp?page=${selected_value}`
    }
}