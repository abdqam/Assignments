import React, { Component } from 'react'
import "../css/Main.css"

export class Main extends Component {
    render() {
        return (
            <div className="Main">
                <>{this.props.children}</>
            </div>
        )
    }
}

export default Main
