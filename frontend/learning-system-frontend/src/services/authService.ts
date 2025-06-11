import type {AuthRequest, AuthResponse, RegisterRequest} from "../models/user.ts";

const API_BASE_URL = 'http://localhost:8080/api/auth';

export const authService = {

    async login(request: AuthRequest): Promise<AuthResponse> {

        const response = await fetch(`${API_BASE_URL}/login`, {

            method: 'POST',

            headers: {

                'Content-Type': 'application/json',

            },

            body: JSON.stringify(request),

        });

        if (!response.ok) {

            throw new Error('Login failed');

        }

        return response.json();

    },

    async register(request: RegisterRequest): Promise<AuthResponse> {

        const response = await fetch(`${API_BASE_URL}/register`, {

            method: 'POST',

            headers: {

                'Content-Type': 'application/json',

            },

            body: JSON.stringify(request),

        });

        if (!response.ok) {

            // check if the response is JSON

            const contentType = response.headers.get('Content-Type');

            if (contentType && contentType.includes('application/json')) {

                const errorData = await response.json();

                throw new Error(errorData.message || 'Registration failed');

            } else {

                // if response is not JSON, read it as text

                const errorText = await response.text();

                throw new Error(errorText || 'Registration failed');

            }

        }

        return response.json();

    }


};
