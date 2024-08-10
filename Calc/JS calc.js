const display = document.getElementById("display");

function appendToDisplay(input) {
    display.value += input;
}

function clearDisplay() {
    display.value = "";
}

function calculate() {
    try {
        display.value = eval(display.value.replace('e^', 'Math.exp').replace('sin', 'Math.sin').replace('cos', 'Math.cos'));
    } catch (error) {
        display.value = "Error";
    }
}